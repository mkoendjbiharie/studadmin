package com.adekus.studentadministratie.repositories;

import com.adekus.studentadministratie.domain.Maxnummers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MaxNummersRepository extends JpaRepository<Maxnummers,Integer> {

    @Query(value = "SELECT MAX(max) FROM maxnummers WHERE collegejaar_id = :collegejaar AND " +
            "studierichting_id = :studierichting",nativeQuery = true)
    Long findMaxByCollegejaarAndStudierichting(@Param("collegejaar") Long collegejaar,@Param("studierichting") String studierichting);


    /*
    @Modifying
    @Query("update User u set u.active = false where u.lastLoginDate < :date",nativeQuery = true)
    void deactivateUsersNotLoggedInSince(@Param("date") LocalDate date);
     */
    //update max_nummers set max=maxnummer where collegejaar=jr and studierichting=sr
    @Modifying
    @Query(value = "update maxnummers m set m.max = :max_value where m.collegejaar_id = :collegejaar and " +
            "m.studierichting_id = :studierichting",nativeQuery = true)
    void updateMaxnummers(@Param("collegejaar") Long collegejaar,
                          @Param("studierichting") String studierichting,
                          @Param("max") Long max_value);

    /*
    @Modifying
    @Query(
      value =
        "insert into Users (name, age, email, status) values (:name, :age, :email, :status)",
      nativeQuery = true)
    void insertUser(@Param("name") String name, @Param("age") Integer age,
      @Param("status") Integer status, @Param("email") String email);
     */
    @Modifying
    @Query(value="insert into maxnummers(max,collegejaar_id,studierichting_id) " +
            "values(:max_value,:collegejaar,:studierichting)",nativeQuery = true)
    void insertNewMaxnummer(@Param("collegejaar") Long collegejaar,
                            @Param("studierichting") String studierichting,
                            @Param("max") Long max_value);

}
