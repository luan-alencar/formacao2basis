package com.basis.campina.xtarefas.service.event;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResponsavelEvent extends DefaultEvent {

    public ResponsavelEvent(Integer id) {
        super(id);
    }
}
