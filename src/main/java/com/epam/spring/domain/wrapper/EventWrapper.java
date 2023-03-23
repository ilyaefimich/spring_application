package com.epam.spring.domain.wrapper;

import com.epam.spring.domain.entity.EventEntity;
import lombok.Data;

import java.util.List;

@Data
public class EventWrapper {

    private List<EventEntity> events;

}
