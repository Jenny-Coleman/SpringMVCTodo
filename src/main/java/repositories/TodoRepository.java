package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Todo;

interface TodoRepository extends JpaRepository<Todo, Long> {
	
}