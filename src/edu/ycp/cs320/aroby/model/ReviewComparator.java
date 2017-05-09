package edu.ycp.cs320.aroby.model;

import java.time.LocalDateTime;
import java.util.Comparator;

public class ReviewComparator implements Comparator<Review> {

	public int compare(Review obj, Review obj1){
		
		LocalDateTime a = LocalDateTime.parse(obj.getDate());
		LocalDateTime b = LocalDateTime.parse(obj1.getDate());
		if(a.getYear() > b.getYear()){
			return 1;
		}
		else if(a.getYear() < b.getYear()){
			return -1;
		}
		else if(a.getYear() == b.getYear()){
			if(a.getDayOfYear() > b.getDayOfYear()){
				return 1;
			}
			else if(a.getDayOfYear() < b.getDayOfYear()){
				return -1;
			}
			else if(a.getDayOfYear() == b.getDayOfYear()){
				if(a.getHour() > b.getHour()){
					return 1;
				}
				else if(a.getHour() < b.getHour()){
					return -1;
				}
				else if(a.getHour() == b.getHour()){
					if(a.getMinute() > b.getMinute()){
						return 1; 
					}
					else if(a.getMinute() < b.getMinute()){
						return -1;
					}
					else if(a.getMinute() == b.getMinute()){
						if(a.getSecond() > b.getSecond()){
							return 1;
						}
						else if(a.getSecond() < b.getSecond()){
							return -1;
						}
						else if(a.getSecond() == b.getSecond()){
							if(a.getNano() > b.getNano()){
								return 1;
							}
							else if(a.getNano() < b.getNano()){
								return -1;
							}
						}
					}
					
				}
			}
		}
		return 0;
	}
}
