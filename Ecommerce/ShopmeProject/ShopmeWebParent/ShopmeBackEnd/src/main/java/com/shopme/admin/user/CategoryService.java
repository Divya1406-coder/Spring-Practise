package com.shopme.admin.user;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shopme.admin.category.CategoryRepository;
import com.shopme.common.entity.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;

	public List<Category> listAll(String sortDir) {
		Sort sort = Sort.by("name");
		
		if(sortDir.equals("asc")) {
			sort = sort.ascending();
		}else if(sortDir.equals("desc")) {
			sort = sort.descending();
		}
		List<Category> rootCategories = repo.findRootCategories(sort);
		return listHierarchicalCategories(rootCategories,sortDir);
	}
	
	private List<Category> listHierarchicalCategories(List<Category> rootCategrories,String sortDir){
		List<Category> hierarchicalCategories = new ArrayList<>();
		
		for(Category rootCategory : rootCategrories) {
			hierarchicalCategories.add(Category.copyFull(rootCategory));
			
			Set<Category> children = sortSubCategories(rootCategory.getChildren(),sortDir);
			
			for(Category subCategory: children) {
				String name = "--" + subCategory.getName();
				 hierarchicalCategories.add(Category.copyFull(rootCategory, name));
				 
				 listSubHierarchicalCategories(hierarchicalCategories,subCategory,1,sortDir);
			}
		}
		return hierarchicalCategories;
	}
	
	private void listSubHierarchicalCategories(List<Category> hierarchicalCategories,
			Category parent,int subLevel,String sortDir) {

		Set<Category> children = sortSubCategories(parent.getChildren(),sortDir);
		int newSubLevel = subLevel + 1;
		for(Category subCategory : children) {
			String name = "";
			for (int i = 0; i < newSubLevel; i++) {
				name += "--";
			}
			name += subCategory.getName();
			hierarchicalCategories.add(Category.copyFull(subCategory,name));
			listSubHierarchicalCategories(hierarchicalCategories,subCategory,newSubLevel,sortDir);
			
		}
	}
	public Category save(Category category) {
		return repo.save(category);
	}

	public List<Category> listCategoriesUsedInForm() {
		List<Category> categoriesUsedInForm = new ArrayList<>();
		Iterable<Category> categoriesInDB = repo.findRootCategories(Sort.by("name").ascending());

		for (Category category : categoriesInDB) {
			if (category.getParent() == null) {
				categoriesUsedInForm.add(Category.copyIdAndName(category));

				Set<Category> children = sortSubCategories(category.getChildren());
				for (Category subCategory : children) {
					String name = "--" + subCategory.getName();
					categoriesUsedInForm.add(Category.copyIdAndName(subCategory.getId(), name));
					listSubCategoriesUsedInForm(categoriesUsedInForm, subCategory, 1);
				}

			}
		}

		return categoriesUsedInForm;
	}

	public void listSubCategoriesUsedInForm(List<Category> categoriesUsedInForm, Category parent, int subLevel) {
		int newSubLevel = subLevel + 1;
		Set<Category> children = sortSubCategories(parent.getChildren());

		for (Category subCategory : children) {
			String name = "";
			for (int i = 0; i < newSubLevel; i++) {
				name += "--";
			}
			name += subCategory.getName();
			categoriesUsedInForm.add(Category.copyIdAndName(subCategory.getId(), name));
			listSubCategoriesUsedInForm(categoriesUsedInForm, subCategory, newSubLevel);
		}
	}
	
	public Category get(int id) throws CategoryNotFoundException {
		try {
			return repo.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new CategoryNotFoundException("Could not find any Category with ID " + id);
		}
	}
	
	public String checkUnique(Integer id, String name, String alias) {
		boolean isCreatingNew = (id == null || id == 0);
		
		Category categoryByName = repo.findByName(name);
		
		if(isCreatingNew) {
			if(categoryByName != null) {
				return "DuplicateName";
			}else {
				Category categoryByAlias = repo.findByAlias(alias);
				if(categoryByAlias != null) {
					return "DuplicateAlias";
				}
			}
		}else {
			if(categoryByName != null && categoryByName.getId() != id) {
				return "DuplicateName";
			}else {
				Category categoryByAlias = repo.findByAlias(alias);
				if(categoryByAlias != null && categoryByAlias.getId() != id) {
					return "DuplicateAlias";
				}
			}
		}
		return "OK";
	}
	private SortedSet<Category> sortSubCategories(Set<Category> children) {
		return sortSubCategories(children,"asc");
	}
	private SortedSet<Category> sortSubCategories(Set<Category> children,String sortDir) {
		SortedSet<Category> sortedChildren = new TreeSet<>(new Comparator<Category>() {
			@Override()
			public int compare(Category c1,Category c2) {
				if(sortDir.equals("asc")) {
					return c1.getName().compareTo(c2.getName());
				}else {
					return c2.getName().compareTo(c1.getName());
				}
			}
		});
		
		sortedChildren.addAll(children);
		return sortedChildren;
 	}
}

