package com.polis.api.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Передается только плеер статус вашего скилла,
 * т.е если пользователь слушал музыку из скилла музыка, плеер статус вам передан не будет.
 *
 * Если скиллл отдает плеер, то при первом обращении в скилл player_status передан не будет, так как еще плеера нет,
 * он будет отправлен при втором и последующем запросе в скилл если плеер активен
 */
@AllArgsConstructor
@NoArgsConstructor
public class ClientPlayerStatus {
    @JsonProperty("track_number")
    public int trackNumber;

    @JsonProperty("elapsed")
    public int elapsed;

    @JsonProperty("duration")
    public int duration;

    @JsonProperty("track_id")
    public int trackId;

}
