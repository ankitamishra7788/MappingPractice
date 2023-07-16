package com.example.MappingPractice.repository;


import com.example.MappingPractice.model.Course;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepo extends JpaRepository<Course,Long> {

    @Transactional
    @Modifying
    @Query("delete from Course where courseId=:courseId")
    public void deleteCourse(@Param("courseId") Long courseId);

    @Transactional
    @Modifying
    @Query("update Course set courseTitle =:courseTitle where courseId = :courseId")
    public void updateCourseTitle(@Param("courseTitle") String courseTitle, @Param("courseId") Long courseId);
}