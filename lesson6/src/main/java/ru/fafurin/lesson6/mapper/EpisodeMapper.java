package ru.fafurin.lesson6.mapper;

import ru.fafurin.lesson6.dto.EpisodeDTO;
import ru.fafurin.lesson6.model.Episode;

public class EpisodeMapper {

    public static Episode getEpisode(EpisodeDTO episodeDTO) {
        Episode episode = new Episode();
        episode.setName(episodeDTO.getName());
        episode.setAirDate(episodeDTO.getAir_date());
        episode.setEpisode(episodeDTO.getEpisode());
        episode.setUrl(episodeDTO.getUrl());
        episode.setCreated(episodeDTO.getCreated());
        return episode;
    }
}
