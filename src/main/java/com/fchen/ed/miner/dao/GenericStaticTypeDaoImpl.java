package com.fchen.ed.miner.dao;

import java.util.HashSet;
import java.util.Set;

import com.fchen.ed.miner.model.Commodity;

public abstract class GenericStaticTypeDaoImpl<T> implements GenericStaticTypeDao<T> {
	
	private Set<T> masterSet = new HashSet<T>();
	
	protected abstract void updateSearchMap();
	
	public void addAll(Set<T> tSet) {
		masterSet.addAll(tSet);
		updateSearchMap();
	}

	public void add(T t) {
		masterSet.add(t);
		updateSearchMap();
	}

	public Set<T> getAll() {
		return masterSet;
	}

}
