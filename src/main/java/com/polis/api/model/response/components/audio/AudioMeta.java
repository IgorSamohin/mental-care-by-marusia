package com.polis.api.model.response.components.audio;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AudioMeta {
    private String title;

    @JsonProperty("sub_title")
    private String subTitle;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private AudioArt art;

    public AudioMeta(String audioTitle, String audioSubTitle, String artUrl) {
        this.title = audioTitle;
        this.subTitle = audioSubTitle;
        this.art = new AudioArt(artUrl);
    }
}
