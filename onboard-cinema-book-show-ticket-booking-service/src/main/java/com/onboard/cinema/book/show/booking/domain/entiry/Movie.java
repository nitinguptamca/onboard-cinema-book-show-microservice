package com.onboard.cinema.book.show.booking.domain.entiry;

import com.onboard.cinema.book.show.common.entity.BaseEntity;
import com.onboard.cinema.book.show.common.valueobject.MovieId;
import java.time.Duration;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class Movie extends BaseEntity<MovieId> {
    private String title;
    private String description;
    private Duration duration;
    private String publishLanguage;
    private String country;
    private LocalDate releaseDate;

    public Movie(String title,
                 String description,
                 Duration duration,
                 String publishLanguage,
                 String country,
                 LocalDate releaseDate) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.publishLanguage = publishLanguage;
        this.country = country;
        this.releaseDate = releaseDate;
    }

    public Movie(MovieId movieId) {
        super.setId(movieId);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Duration getDuration() {
        return duration;
    }

    public String getPublishLanguage() {
        return publishLanguage;
    }

    public String getCountry() {
        return country;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }
}
