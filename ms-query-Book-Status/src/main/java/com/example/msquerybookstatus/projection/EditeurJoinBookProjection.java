package com.example.msquerybookstatus.projection;


import com.example.coreapi.events.BookAddedEvent;
import com.example.coreapi.events.BookRemovedEvent;
import com.example.coreapi.events.EditeurCreatedEvent;
import com.example.msquerybookstatus.Entities.CompositeKey;
import com.example.msquerybookstatus.Entities.EditeurJoinBook;
import com.example.msquerybookstatus.Entities.EditeurTemp;
import com.example.msquerybookstatus.dao.EditeurJoinBookRepository;
import com.example.msquerybookstatus.dao.EditeurTempRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EditeurJoinBookProjection {

    @Autowired
    EditeurJoinBookRepository editeurJoinBookRepository;
    @Autowired
    EditeurTempRepository editeurTempRepository;

    @EventHandler
    public void addEditeur(EditeurCreatedEvent event)
    {
        editeurTempRepository.save(new EditeurTemp(event.getEditeurId(), event.getName()));
    }
    @EventHandler
    public void addBook(BookAddedEvent event)
    {
        EditeurJoinBook editeurJoinBook =new EditeurJoinBook();
        editeurJoinBook.setKeyJoin(new CompositeKey(event.getEditeurId(), event.getIsbn()));
        editeurJoinBook.setBookTitle(event.getTitle());
        editeurJoinBook.setEditeurName(
                    editeurTempRepository.findById(event.getEditeurId()).get().getName());

        editeurJoinBookRepository.save(editeurJoinBook);
    }

    @EventHandler
    public void removeBook(BookRemovedEvent event){
        editeurJoinBookRepository.deleteByKeyJoin_Isbn(event.getIsbn());
    }
}
