package edu.poly.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import edu.poly.model.User;
import edu.poly.model.Video;

public class VideoDao extends AbstractEntityDao<Video>{

	public VideoDao() {
		super(Video.class);
	}

}
