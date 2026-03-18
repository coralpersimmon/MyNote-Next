package com.coralpersimmon.mynotenext.controller;

import com.coralpersimmon.mynotenext.dao.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;
}
