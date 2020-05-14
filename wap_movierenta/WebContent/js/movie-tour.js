"use strict";

(function($) {
    const app = {
        init: function() {
            this.ulElement = $("#grid-container");
            this.movieTemplate = $('#movie-template');
            this.slideShowContainer = $("#slideshow-container");
            this.slideShowTemplate = $("#slideshow-template");
            this.pageControl = $("#page-control");
            this.pageItemTemplate = $("#page-item-template");
            this.slideIndex = 0;
            this.loadMovies();
            //this.showSlides();
            this.bindEvents();
            
            
        },
        bindEvents: function() {
            $(".dot").on("click", (e) => {
                let id = e.target.id.replace("dot-", "");
                this.slideIndex = id;
                clearTimeout(this.slideTimer);
                this.showSlides();
            });
        },
        loadMovies: function() {
            $.ajax({
                url: "moviesdata",
                dataType: 'json',
                success: (data) => {
                    console.log("ajax: " + this);
                    const movies = data;
                    let index = 0;
                    // Fill
                    for(const movie of movies) {
                        this.renderMovie(movie);
                        if (index <= 10) {
                            this.renderSlide(movie);
                            this.renderDotControl(index);
                            index++;
                        }
                    }
                    this.showSlides();
                },
                error: (error) => {
                    console.log("ajax: " + error);
                }
            });
        },
        renderMovie: function(movie) {
            const date = new Date(movie.release_date);
            movie.year = date.getFullYear();
            movie.movieLink = "movie?id=" + movie.id;
            let overview = movie.overview;
            if (overview.length > 100) overview = overview.substring(0, 100) + "...";

            movie.description = overview;
            this.ulElement.loadTemplate(this.movieTemplate, movie, { append: true })
        },
        renderSlide: function(movie) {
            const url = movie.backdrop_path;
            movie.cover = url.replace("w500", "original");
            this.slideShowContainer.loadTemplate(this.slideShowTemplate, movie, { append: true })
        },
        renderDotControl: function(index) {
            this.pageControl.loadTemplate(this.pageItemTemplate, {"index":"dot-" + index}, { append: true })
        },
        showSlides: function() {
            let slides = $(".mySlides");
            for (let i = 0; i < slides.length; i++) {
                $(slides[i]).hide();
                $("#dot-" + i).removeClass("active");
            }
            this.slideIndex++;
            if (this.slideIndex > slides.length) this.slideIndex = 1;
            $(slides[this.slideIndex-1]).show();
            $("#dot-" + (this.slideIndex-1)).addClass("active");
            this.slideTimer = setTimeout(() => {
                this.showSlides();
            }, 5000)
        }
    }
    app.init();

})(jQuery);
