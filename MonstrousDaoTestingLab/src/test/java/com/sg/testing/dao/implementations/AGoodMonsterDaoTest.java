/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 
 */
package com.sg.testing.dao.implementations;

import com.sg.testing.model.Monster;
import com.sg.testing.model.MonsterType;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Steven
 */
public class AGoodMonsterDaoTest {
    final private AGoodMonsterDao dao;
    final static private Monster monster1 = new Monster("Monster1", MonsterType.YETI, 1, "Cats");
    final static private Monster monster2 = new Monster("Monster2", MonsterType.LIZARDMAN, 2, "Dogs");
    
    final int ID1 = 968746;
    final int ID2 = 98764;
    
    public AGoodMonsterDaoTest() {
        dao = new AGoodMonsterDao();
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
        dao.removeMonster(ID1);
        dao.removeMonster(ID2);
    }
    
    /**
     * Test the intialization of AGoodMonsterDao
     */
    @Test
    public void Should_Be_Empty_After_Initializing() {
        List<Monster> monsters;
        Monster monster;
        
        // Get all monsters
        monsters = dao.getAllMonsters();
        
        // Storage should be empty before adding any monsters
        assertTrue(
            monsters.isEmpty(),
            "Storage should be empty"
        );
    }
    
    /**
     * Tests adding one monster
     */
    @Test
    public void Should_Add_1_Monster() {
        List<Monster> monsters;
        Monster monster;
        
        // Add monster1
        monster = dao.addMonster(ID1, monster1);
        assertTrue(
            (monster == null),
            "ID ID1 should be available"
        );
        
        // Storage should have 1 monster
        monsters = dao.getAllMonsters();
        assertTrue(
            (monsters.size() == 1),
            "Storage should have 1 monster"
        );
    }
    
    /**
     * Tests adding 2 monsters
     */
    @Test
    public void Should_Add_2_Monsters() {
        List<Monster> monsters;
        Monster monster;
        
        // Add monster1 and monster2
        monster = dao.addMonster(ID1, monster1);
        assertTrue(
            (monster == null),
            "ID ID1 should be available"
        );
        monster = dao.addMonster(ID2, monster2);
        assertTrue(
            (monster == null),
            "ID ID2 should be available"
        );
        
        // Storage should have 2 monsters
        monsters = dao.getAllMonsters();
        assertTrue(
            (monsters.size() == 2),
            "Storage should have 2 monsters"
        );
        
        // DAO at ID1 should be monster1
        monster = dao.getMonster(ID1);
        assertTrue(
            (
                (monster != null) && 
                monster.equals(monster1)
            ),
            "DAO at ID1 should be monster1"
        );
        
        // DAO at 1 should be monster2
        monster = dao.getMonster(ID2);
        assertTrue(
            (
                (monster != null) && 
                monster.equals(monster2)
            ),
            "DAO at ID2 should be monster2"
        );
    }

    /**
     * Tests adding 2 monsters onto the same ID
     */
    @Test
    public void Should_Fail_To_Add_Monster_Onto_Other_Monster() {
        List<Monster> monsters;
        Monster monster;
        
        // Add monster1 and monster2
        monster = dao.addMonster(ID1, monster1);
        assertTrue(
            (monster == null),
            "ID ID1 should be available"
        );
        monster = dao.addMonster(ID1, monster2);
        assertTrue(
            (monster1.equals(monster)),
            "ID ID2 should be monster1"
        );
        
        // Storage should have 1 monster
        monsters = dao.getAllMonsters();
        assertTrue(
            (monsters.size() == 1),
            "Storage should have 1 monster"
        );
        
        // DAO at ID1 should be monster2
        monster = dao.getMonster(ID1);
        assertTrue(
            (
                (monster != null) && 
                monster2.equals(monster)
            ),
            "DAO at ID1 should be monster2"
        );
    }
}
