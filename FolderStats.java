package io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FolderStats {

	public static void main(String[] args) throws IOException {

          Path p = Paths.get("f:\\classroom\\dec6");
          
          CountFolder cf = new CountFolder();
          Files.walkFileTree(p, cf);
          System.out.printf("Folders %d, Files %d",  cf.getFolders(), cf.getFiles());
	}
	
	static class CountFolder extends SimpleFileVisitor<Path> {
        int folders, files;
        
		public int getFolders() {
			return folders;
		}

		public int getFiles() {
			return files;
		}

		@Override
		public FileVisitResult preVisitDirectory(Path arg0, BasicFileAttributes arg1) throws IOException {
		    folders++;
			return FileVisitResult.CONTINUE; 
		}

		@Override
		public FileVisitResult visitFile(Path arg0, BasicFileAttributes arg1) throws IOException {
			files++;
			return FileVisitResult.CONTINUE;
		}
		
	}

}
