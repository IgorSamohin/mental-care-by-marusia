package com.polis.api.model.response.components.audio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AudioStream {
    /**
     * ID аудио внутри плейлиста, должен быть уникальным для каждого аудио
     */
    @JsonProperty("track_id")
    private String trackId;

    @JsonProperty("source_type")
    private AudioSource sourceType;

    /**
     * В случае source_type url представляет ссылку на аудиозапись,
     * в случае source_type vk представляет собой audio_vk_id аудиозаписи VK
     */
    private String source;
}
