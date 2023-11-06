package com.docengine.service;
import org.springframework.stereotype.*;
@Service
public class DocumentExportService {
    public String exportToMarkdown(String content) { return content; }
    public String exportToHtml(String content) { return "<html>" + content + "</html>"; }
}
