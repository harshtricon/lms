package com.example.lms.service;

import com.example.lms.dto.PublisherDTO;
import com.example.lms.dto.PublisherSaveDTO;
import com.example.lms.dto.PublisherUpdateDTO;

import java.util.List;

public interface PublisherService {

    String addPublisher(PublisherSaveDTO publisherSaveDTO);

    List<PublisherDTO> getAllPublisher();

    String updatePublisher(PublisherUpdateDTO publisherUpdateDTO);

    String deletePublisher(int id);
}