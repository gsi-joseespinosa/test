package com.thecodeexamples.apachepoi.word;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 *  Puzeyev Alexandr, https://thecodeexamples.com
 */
public class App {

  public static void main(String[] args) throws IOException, InvalidFormatException {
    XWPFDocument document = new XWPFDocument(OPCPackage.open("template.docx"));
    for (XWPFParagraph paragraph : document.getParagraphs()) {
      for (XWPFRun run : paragraph.getRuns()) {
        String text = run.getText(0);
        text = text.replace("${name}", "John");
        run.setText(text, 0);
        System.out.println(text);
      }
    }
    document.write(new FileOutputStream("output.docx"));

  }
}
