package com.coralpersimmon.mynotenext.dto;

import com.coralpersimmon.mynotenext.constant.NoteCategory;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteRequest {
    @NotNull
    private Integer userId;

    @NotNull
    private NoteCategory category;

    @NotNull
    private String title;

    private String content;
}
