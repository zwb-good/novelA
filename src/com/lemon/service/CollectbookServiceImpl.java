package com.lemon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemon.dao.CollectbookMapper;
import com.lemon.pojo.Collectbook;
import com.lemon.pojo.CollectbookExample;
import com.lemon.pojo.CollectbookExample.Criteria;
@Service
public class CollectbookServiceImpl implements CollectbookService {
	@Autowired
	private CollectbookMapper collectbookMapper;
	
	@Override
	public List<Collectbook> getCollectbook(Integer userId) throws Exception {
		CollectbookExample example = new CollectbookExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		return collectbookMapper.selectByExampleAndBook(example);
	}
	
	@Override
	public int insert(Collectbook collectbook) throws Exception {
		CollectbookExample example = new CollectbookExample();
		Criteria criteria = example.createCriteria();
		criteria.andBookIdEqualTo(collectbook.getBookId());
		if(collectbookMapper.selectByExample(example).size() > 0 ){
			return 0;
		}else {
			return collectbookMapper.insertSelective(collectbook);
		}
	}
	
	@Override
	public int delete(Integer[] ids) throws Exception {
		return collectbookMapper.deleteByIds(ids);
	}
}
