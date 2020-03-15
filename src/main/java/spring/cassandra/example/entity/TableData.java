package spring.cassandra.example.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TableData {

	Map<String, Object> data = new HashMap<>();

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

}
