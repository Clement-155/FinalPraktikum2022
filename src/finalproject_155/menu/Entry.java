/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject_155.menu;

import java.util.Comparator;

/**
 *
 * @author Christopher Clement
 */
    public class Entry{

        private String Name = null;
        private Integer Score = null;

        public Entry(String Name, Integer Score) {
            this.Name = Name;
            this.Score = Score;
        }
        /**
         * @return the Name
         */
        public String getName() {
            return Name;
        }

        /**
         * @param Name the Name to set
         */
        public void setName(String Name) {
            this.Name = Name;
        }

        /**
         * @return the Score
         */
        public Integer getScore() {
            return Score;
        }

        /**
         * @param Score the Score to set
         */
        public void setScore(Integer Score) {
            this.Score = Score;
        }

        public static Comparator<Entry> COMPARE_BY_SCORE = new Comparator<Entry>() {
            public int compare(Entry one, Entry other) {
                return other.Score - one.Score;
            }
        };
    }