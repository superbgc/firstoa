package utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import cn.itcast.oa.domain.Privilege;

public class PrivilegeUtils {
	public static List<Privilege> getTreeList(List<Privilege> topList,Long removeId){
		List<Privilege> treeList=new ArrayList<Privilege>();
		walkTree(topList,treeList,"┣",removeId);
		return treeList;
	}
	public static void walkTree(Collection<Privilege> topList,List<Privilege> treeList,String prefix,Long removeId){
		for(Privilege d:topList){
			if(removeId!=null&&d.getId().equals(removeId)){
				continue;
			}
			Privilege copy=new Privilege();
			copy.setId(d.getId());
			copy.setName(prefix+d.getName());
			//顶点
			treeList.add(copy);
			//子树
			Set<Privilege> children=d.getChildren();
			walkTree(children,treeList,"　　"+prefix,removeId);
		}
	}
}
