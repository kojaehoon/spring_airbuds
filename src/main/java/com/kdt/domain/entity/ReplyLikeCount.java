package com.kdt.domain.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ReplyLikeCount {

	@Id
	@Column(name = "seq")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	
	@Column(name = "writer")
	private String writer;
	
	@Column(name = "contents")
	private String contents;
	
	@Column(name = "write_date")
	private Timestamp writeDate;
	
	@Column(name = "track_id")
	private Long trackId;
	
	@Column(name = "like_count")
	private Long likeCount;

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Timestamp getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}

	public Long getTrackId() {
		return trackId;
	}

	public void setTrackId(Long trackId) {
		this.trackId = trackId;
	}

	public Long getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Long likeCount) {
		this.likeCount = likeCount;
	}

	public ReplyLikeCount(Long seq, String writer, String contents, Timestamp writeDate, Long trackId, Long likeCount) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.contents = contents;
		this.writeDate = writeDate;
		this.trackId = trackId;
		this.likeCount = likeCount;
	}

	public ReplyLikeCount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
