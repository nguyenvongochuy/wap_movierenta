package com.mum.projectx.model;

public class Movie {
	private long id;
	private String title;
	private double vote_average;
	private String overview;
	private String release_date;
	private int duration;
	private String poster_path;
	private String backdrop_path;
	
	public Movie() {
	}

	public Movie(long id, String title, double vote_average, String overview, String release_date, int duration,
			String poster_path, String backdrop_path) {
		this.id = id;
		this.title = title;
		this.vote_average = vote_average;
		this.overview = overview;
		this.release_date = release_date;
		this.duration = duration;
		this.poster_path = poster_path;
		this.backdrop_path = backdrop_path;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getVote_average() {
		return vote_average;
	}

	public void setVote_average(double vote_average) {
		this.vote_average = vote_average;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public String getPoster_path() {
		return poster_path;
	}

	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}

	public String getBackdrop_path() {
		return backdrop_path;
	}

	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((backdrop_path == null) ? 0 : backdrop_path.hashCode());
		result = prime * result + duration;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((overview == null) ? 0 : overview.hashCode());
		result = prime * result + ((poster_path == null) ? 0 : poster_path.hashCode());
		result = prime * result + ((release_date == null) ? 0 : release_date.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		long temp;
		temp = Double.doubleToLongBits(vote_average);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (backdrop_path == null) {
			if (other.backdrop_path != null)
				return false;
		} else if (!backdrop_path.equals(other.backdrop_path))
			return false;
		if (duration != other.duration)
			return false;
		if (id != other.id)
			return false;
		if (overview == null) {
			if (other.overview != null)
				return false;
		} else if (!overview.equals(other.overview))
			return false;
		if (poster_path == null) {
			if (other.poster_path != null)
				return false;
		} else if (!poster_path.equals(other.poster_path))
			return false;
		if (release_date == null) {
			if (other.release_date != null)
				return false;
		} else if (!release_date.equals(other.release_date))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (Double.doubleToLongBits(vote_average) != Double.doubleToLongBits(other.vote_average))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", vote_average=" + vote_average + ", overview=" + overview
				+ ", release_date=" + release_date + ", duration=" + duration + ", poster_path=" + poster_path
				+ ", backdrop_path=" + backdrop_path + "]";
	}

	
	

	
	
}
