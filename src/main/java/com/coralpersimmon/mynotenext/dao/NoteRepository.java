package com.coralpersimmon.mynotenext.dao;

import com.coralpersimmon.mynotenext.model.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Integer> {
}
