/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

/**
 *
 * @author USER
 */
// Custom exception for invalid movie data
class InvalidMovieException extends Exception {
    public InvalidMovieException(String message) {
        super(message);
    }
}
