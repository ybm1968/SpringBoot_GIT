package com.joeun.board.dto;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Board {
    
    private int boardNo;
    private String title;
    private String writer;
    private String content;
    private Date regDate;
    private Date updDate;
    private int views;

    private List<MultipartFile> file;
}
