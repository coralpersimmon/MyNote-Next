package com.coralpersimmon.mynotenext.dao;

import com.coralpersimmon.mynotenext.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Integer> {
}
