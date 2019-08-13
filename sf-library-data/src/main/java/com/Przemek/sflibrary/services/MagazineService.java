package com.Przemek.sflibrary.services;

import com.Przemek.sflibrary.model.Magazine;

import java.util.List;

public interface MagazineService extends CrudService<Magazine, Long> {

    List<Magazine> findAllByLanguage(String language);

}
