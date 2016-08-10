package com.siartim.journal.repository;

import com.siartim.journal.model.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by a9jr5626 on 8/8/16.
 */

public interface JournalRepository extends JpaRepository<JournalEntry, Long> {
//    List<JournalEntry> findByCreatedAfter(Date date);

//    @Query("select j from JournalEntry j where j.title like %?1%")
//    List<JournalEntry> findByCustomQuery(String word);
}

