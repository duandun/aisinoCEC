package com.aisino.cec.common.util.web;

import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HtmlUtils;
import org.springframework.web.util.JavaScriptUtils;

/**
 * 
 * @author jwh
 * @date 2015-04-29
 */
@Controller
@RequestMapping("/base")
public class BaseController {

	@Autowired
	protected Validator validator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		hook(binder);
	}

	protected void hook(WebDataBinder binder) {

		/**
		 * 防止XSS攻击
		 */
		binder.registerCustomEditor(String.class, new StringEscapeEditor(true,
				false));
		binder.registerCustomEditor(Date.class, new DateEditor());
		binder.registerCustomEditor(BigDecimal.class, new BigDecimalEditor());

		binder
				.registerCustomEditor(String.class, new StringTrimmerEditor(
						true));
	}
	
    /**
     * 用户跳转JSP页面
     * 
     * @param folder
     *            路径
     * @param jspName
     *            JSP名称(不加后缀)
     * @return 指定JSP页面
     */
    @RequestMapping("/{folder}/{jspName}")
    public ModelAndView redirectJsp(@PathVariable String folder, @PathVariable String jspName) {
        String redirectURL = "/" + folder + "/" + jspName;
        return new ModelAndView(redirectURL);
    }
	
	protected class StringEscapeEditor extends PropertyEditorSupport {
		private boolean escapeHTML;// 编码HTML
		private boolean escapeJavaScript;// 编码javascript

		public StringEscapeEditor(boolean escapeHTML, boolean escapeJavaScript) {
			super();
			this.escapeHTML = escapeHTML;
			this.escapeJavaScript = escapeJavaScript;
		}

		@Override
		public String getAsText() {
			Object value = getValue();
			return value != null ? value.toString() : "";
		}

		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if (text == null) {
				setValue(null);
			} else {
				String value = text;
				if (escapeHTML) {
					value = HtmlUtils.htmlEscape(value);
				}
				if (escapeJavaScript) {
					value = JavaScriptUtils.javaScriptEscape(value);
				}
				setValue(value);
			}
		}
	}

	/**
	 * 使用springMvc，直接将页面参数绑定到对象中，对象中有属性为Date时会报错，此时需要处理下
	 * 
	 * @author jwh
	 * 
	 */
	protected class DateEditor extends PropertyEditorSupport {

		private final DateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd");
		private final DateFormat TIMEFORMAT = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		private DateFormat dateFormat;
		private boolean allowEmpty = true;

		public DateEditor() {
		}

		/**
		 * Parse the Date from the given text, using the specified DateFormat.
		 */
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if (this.allowEmpty && !StringUtils.hasText(text)) {
				// Treat empty String as null value.
				setValue(null);
			} else {
				try {
					if (this.dateFormat != null)
						setValue(this.dateFormat.parse(text));
					else {
						if (text.contains(":")) {
							setValue(TIMEFORMAT.parse(text));
							this.dateFormat = TIMEFORMAT;
						} else {
							setValue(DATEFORMAT.parse(text));
							this.dateFormat = DATEFORMAT;
						}
					}
				} catch (ParseException ex) {
					throw new IllegalArgumentException("Could not parse date: "
							+ ex.getMessage(), ex);
				}
			}
		}

		/**
		 * Format the Date as String, using the specified DateFormat.
		 */
		@Override
		public String getAsText() {
			Date value = (Date) getValue();
			DateFormat dateFormat = this.dateFormat;
			if (dateFormat == null)
				dateFormat = TIMEFORMAT;
			return (value != null ? dateFormat.format(value) : "");
		}
	}

	/**
	 * 使用springMvc，直接将页面参数绑定到对象中，对象中有属性为BigDecimal时会报错，此时需要处理下
	 * 
	 * @author jwh
	 * 
	 */
	protected class BigDecimalEditor extends PropertyEditorSupport {

		private BigDecimalEditor() {
		}

		/**
		 * Parse the Date from the given text, using the specified DateFormat.
		 */
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if (!StringUtils.hasText(text)) {
				// Treat empty String as null value.
				setValue(null);
			} else {
				setValue(new BigDecimal(text.trim()));
			}
		}

		/**
		 * Format the Date as String, using the specified DateFormat.
		 */
		@Override
		public String getAsText() {
			BigDecimal value = (BigDecimal) getValue();
			// 设置小数点有四位，最后一位的取舍方法是四舍五入
			value = value.setScale(4, BigDecimal.ROUND_HALF_UP);
			return value.toString();
		}
	}

}
