package com.fchen.ed.miner.dao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class GenericStaticTypeDaoImpl<T> implements GenericStaticTypeDao<T> {

	protected Set<T> masterSet = new HashSet<T>();

	protected abstract void updateSearchMap();

	public void setMasterSet(Set<T> tSet) {
		masterSet.clear();
		masterSet.addAll(tSet);
		updateSearchMap();
	}

	public void add(T t) {
		if (!masterSet.contains(t)) {
			masterSet.add(t);
			updateSearchMap();
		}
	}

	public Set<T> getAll() {
		return masterSet;
	}

	public void addAll(T[] tArray) {
		masterSet.addAll(Arrays.asList(tArray));
	}

	public void addAll(Set<T> tSet) {
		masterSet.addAll(tSet);
	}
}
