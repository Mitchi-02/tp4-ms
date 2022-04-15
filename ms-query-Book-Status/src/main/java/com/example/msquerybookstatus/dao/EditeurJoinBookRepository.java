package com.example.msquerybookstatus.dao;

import com.example.msquerybookstatus.Entities.CompositeKey;
import com.example.msquerybookstatus.Entities.EditeurJoinBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditeurJoinBookRepository extends JpaRepository<EditeurJoinBook, CompositeKey> {

    int deleteByKeyJoin_Isbn(String isbn);
}
