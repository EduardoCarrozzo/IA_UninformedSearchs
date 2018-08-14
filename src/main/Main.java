/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import base.Problem;
import environment.map.InLocationState;
import environment.map.Map;
import environment.map.MapAgent;
import environment.map.MoveToAction;
import environment.map.SimplifiedRoadMapOfPartOfRomania;
import java.util.List;
import java.util.Optional;
import uninformed.BreadthFirstSearch;

/**
 *
 * @author Carlos A. Casanova P.
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map map = new SimplifiedRoadMapOfPartOfRomania();
        MapAgent agent = new MapAgent(map, SimplifiedRoadMapOfPartOfRomania.ARAD);
        Problem<InLocationState, MoveToAction> prob = agent.formulateProblem(new InLocationState(SimplifiedRoadMapOfPartOfRomania.BUCHAREST));
        Optional<List<MoveToAction>> actions = agent.search(prob, new BreadthFirstSearch<>());
        if(actions.isPresent())
            actions.get().forEach(action -> System.out.println(action.toString()));
        else
            System.out.println("Results not found");
        
//        int[][] casilleros = {{0, 6, 8}, {1, 2, 3}, {4, 5, 7}};
//        EightPuzzle puzzle = new EightPuzzle(casilleros);
//        System.out.print(puzzle);
//        System.out.println();
//        
//        puzzle.moveBlankDown();
//        System.out.print(puzzle);
    }
}
