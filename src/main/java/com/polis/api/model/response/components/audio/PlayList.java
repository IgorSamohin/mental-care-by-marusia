package com.polis.api.model.response.components.audio;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlayList {
    private AudioStream stream;

    /**
     * В случае передачи аудио через source_type vk,
     * meta информация будет взята из VK,
     * если поле meta не передано и непосредственно из поля meta, если оно передано.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private AudioMeta meta;

    public PlayList(String audioVkId) {
        this.stream = new AudioStream("-" + audioVkId, AudioSource.VK, audioVkId);
    }

    //we shall not use this!
    public PlayList(String audioId, String audioUrl, String audioTitle, String audioSubTitle, String artUrl) {
        this.stream = new AudioStream(audioId, AudioSource.URL, audioUrl);
        this.meta = new AudioMeta(audioTitle, audioSubTitle, artUrl);
    }
}
