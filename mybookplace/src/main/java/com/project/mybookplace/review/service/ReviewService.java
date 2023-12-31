package com.project.mybookplace.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mybookplace.review.dao.ReviewDAO;
import com.project.mybookplace.review.domain.Review;

@Service
public class ReviewService {
	@Autowired
	ReviewDAO reviewDAO;
	
	public void writeReview(Review review) {
		reviewDAO.add(review);
	}
	
	public Review getReview(int id) {
		return reviewDAO.get(id);
	}
	
	// 모든 리뷰 가져오는 메서드
	public List<Review> getReviewAll(int page, String order) {
		return reviewDAO.getAll(page, order);
	}
	
	// 특정 유저의 밴된 리뷰를 불러오는 메서드
	public List<Review> getBanAll(int userId) {
		return reviewDAO.getBanAll(userId);
	}
	
	// 장르별로 가져오는 메서드
	public List<Review> getGenre(int start, String genre, String order){
		return reviewDAO.getGenre(start, genre, order);
	}
	
	//특정 유저의 모든 리뷰를 가져오는 메서드.
	public List<Review> getUserReviews(int userId, String order){
		return reviewDAO.getUserReview(userId, order);
	}
	
	//책의 ISBN13번호로 가저오는 메서드.
	public List<Review> getBookReiewsId(int start, Long bookId, String order){
		return reviewDAO.getBookReviewId(start, bookId, order);
	}
	
	//책의 ISBN13번호로 가저오는 메서드.
	public List<Review> getBookReiewsCid(int start, String bookCid, String order){
		return reviewDAO.getBookReviewCid(start, bookCid, order);
	}
	
	//특정 글을 수정.
	public void likes(Review review, int likes) {
		review.setLikes(likes);
		reviewDAO.likesCount(review);
	}
	
	//특정 글을 수정.
	public void edit(Review review) {
		reviewDAO.edit(review);
	}
	
	//특정 글을 숨김.
	public void banR(Review review) {
		reviewDAO.ban(review);
	}
	
	public int page(int showReviewCount) {
		int page = (reviewDAO.getCount()/showReviewCount);
		if(!(reviewDAO.getCount()%showReviewCount == 0)) {
			page = page+ 1;
		}
		
		return page;
	}
	
	public int showPageNumber(int nowPage, int showCount) {
		int pageGroup = (nowPage/5) + 1;
		
		int showPage = (pageGroup-1) * showCount + 1;
				
		return showPage;
	}
	
	
}
