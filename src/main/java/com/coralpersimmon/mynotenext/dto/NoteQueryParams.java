package com.coralpersimmon.mynotenext.dto;

import com.coralpersimmon.mynotenext.constant.NoteCategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteQueryParams {
    private NoteCategory category;
    private String search;
}
