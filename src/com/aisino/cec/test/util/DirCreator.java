package com.aisino.cec.test.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:用于生成测试目录结构和相关的，暂时未对writer进行缓存和对目录生成进行优化
 * @author jwh
 * @version 1.0v
 */
public class DirCreator {

    private String rootPath;
    private int fileCount=0;
    private int sourceFileCount=0;

    
    public int getFileCount(){
        return this.fileCount;
    }
    
    public int getSourceFileCount(){
        return this.sourceFileCount;
    }

    public DirCreator(String rootPath) {
        this.rootPath = rootPath;
    }

    public void createMain(String srcPath, String destPath) throws IOException {
        File srcRoot = new File(srcPath);
        File[] files = null;

        files = srcRoot.listFiles(new DirCreatorFileFilter(".java"));
       
        for (File file : files) {
            String name = file.getName();
            if (!file.isHidden() && file.isDirectory()) {
                File newFile = new File(destPath, name);
                if (!newFile.exists()) {
                    newFile.mkdir();
                }
                boolean b = newFile.createNewFile();
                if (!b) {
                    System.err.println("创建文件" + newFile.getAbsolutePath() + "失败");
                }
                createMain(file.getAbsolutePath(), newFile.getAbsolutePath());
            }
            else if (file.isFile()) {
                sourceFileCount++;
                String newFileName = createNewFileName(file.getName());
                File newFile = new File(destPath, newFileName);
                if (!newFile.exists()) {
                    boolean b = newFile.createNewFile();
                    if (!b) {
                        System.err.println("创建文件" + newFile.getAbsolutePath() + "失败");
                        continue;
                    }
                    fileCount++;
                    String packageName = getPackageName(destPath);
                    if(!isTargetPackage(packageName)){
                    	wirteFile(packageName, newFileName, newFile);
                    }
                }
            }
        }
    }
    
    private static boolean isTargetPackage(String packageName){
    	return packageName.matches("^com.aisino[a-zA-Z_0-9.]+.model$");
    	
    }

    public static void main(String[] args) throws IOException {
        //String rootPath = "F:\\workspace_home\\order";
        //String srcPath = "D:\\Workspaces\\MyEclipse spring\\workflow\\src";
        String rootPath="d:\\target";
        String srcPath="F:\\workspace_home\\order\\src";
        DirCreator dirCreator = new DirCreator(rootPath);
       

        dirCreator.createMain(srcPath, rootPath);
        System.out.println(dirCreator.getSourceFileCount()+" "+dirCreator.getFileCount());
    	 
    }

    private String createNewFileName(String fileName) {
        String newFileName = fileName.substring(0, fileName.lastIndexOf(".")).concat("Test.java");
        return newFileName;
    }

    private String createClassName(String fileName) {
        String newFileName = fileName.substring(0, fileName.lastIndexOf("."));
        return newFileName;
    }

    private void wirteFile(String packageName, String fileName, File newFile) {

        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(newFile));
            String whiteLine = System.getProperty("line.separator");
            bufferedWriter.write("package ".concat(packageName).concat(";"));
            bufferedWriter.write(whiteLine);
            bufferedWriter.write(whiteLine);
            bufferedWriter.write("public class ".concat(createClassName(fileName)).concat("{"));
            bufferedWriter.write(whiteLine);
            bufferedWriter.write(whiteLine);
            bufferedWriter.write("}");

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String getPackageName(String destPath) {

        String osName = System.getProperty("os.name");
        if (osName.contains("Win") || osName.contains("win")) {
            return destPath.substring(rootPath.length() + 1).replaceAll(File.separator.concat(File.separator), ".");
        }
        return destPath.substring(rootPath.length() + 1).replaceAll(File.separator, ".");
    }

    class DirCreatorFileFilter implements FilenameFilter {

        private String[] types;

        private DirCreatorFileFilter(String... types) {
            this.types = types;
        }

        public boolean accept(File dir, String name) {
            File file = new File(dir,name);
            if (!file.isHidden()&&file.isDirectory()) {
                return true;
            }
            for (String str : types) {
                if (name.endsWith(str)) {
                    return true;
                }
            }
            return false;
        }

    }

}
