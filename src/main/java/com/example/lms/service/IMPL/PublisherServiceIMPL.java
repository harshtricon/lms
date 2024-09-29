package com.example.lms.service.IMPL;

import com.example.lms.dto.PublisherDTO;
import com.example.lms.dto.PublisherSaveDTO;
import com.example.lms.dto.PublisherUpdateDTO;
import com.example.lms.entity.Publisher;
import com.example.lms.repo.PublisherRepo;
import com.example.lms.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublisherServiceIMPL implements PublisherService {
    @Autowired
    private PublisherRepo publisherRepo;
    @Override
    public String addPublisher(PublisherSaveDTO publisherSaveDTO) {
        Publisher publisher = new Publisher(
                publisherSaveDTO.getName()
        );
        publisherRepo.save(publisher);
        return publisher.getName();
    }
    @Override
    public List<PublisherDTO> getAllPublisher() {
        List<Publisher> getPublishers = publisherRepo.findAll();
        List<PublisherDTO> publisherDTOList = new ArrayList<>();
        for(Publisher publisher : getPublishers)
        {
            PublisherDTO publisherDTO = new PublisherDTO(
                    publisher.getPublisherid(),
                    publisher.getName()
            );
            publisherDTOList.add(publisherDTO);
        }
        return publisherDTOList;
    }
    @Override
    public String updatePublisher(PublisherUpdateDTO publisherUpdateDTO) {
        if (publisherRepo.existsById(publisherUpdateDTO.getPublisherid()))
        {
            Publisher publisher  = publisherRepo.getById(publisherUpdateDTO.getPublisherid());
            publisher.setName(publisherUpdateDTO.getName());
            publisherRepo.save(publisher);
            return publisher.getName();
        } else {
            System.out.println("Publisher ID Not Exist!!!!!!!!");
        }
        return null;
    }
    @Override
    public String deletePublisher(int id) {
        if(publisherRepo.existsById(id))
        {
            publisherRepo.deleteById(id);
        }
        else
        {
            System.out.println("ID Not Found");
        }
        return null;
    }
}
