package com.siartim.journal.repository;

import com.siartim.journal.domain.Journal;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by a9jr5626 on 8/8/16.
 */

public interface JournalRepository extends JpaRepository<Journal, Long> {

}

