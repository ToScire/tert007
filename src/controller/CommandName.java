package controller;

/**
 * Created by Alexander on 23.02.2016.
 */
public enum CommandName {
    //User
    ADD_NEW_USER,
    LOGIN_USER,
    LOGOUT_USER,
    REGISTRATION_USER,
    FIND_USER_BY_ID,
    FIND_USER_BY_LOGIN,

    GET_USERS_COLLECTION,
    UPDATE_USER,
    REMOVE_USER,

    //Seance
    UPDATE_SEANCE,
    ADD_NEW_SEANCE,
    REMOVE_SEANCE,
    FIND_SEANCE_BY_FILM,
    GET_TODAY_SEANCES,
    GET_SEANCES_BY_DATE,
    GET_SEANCE_BY_ID,

    //Film
    FIND_FILM_BY_ID,
    FIND_FILM_BY_TITLE,
    FIND_FILM_BY_DATE,
    GET_FILMS_COLLECTION,

    ADD_NEW_FILM,
    UPDATE_FILM,
    REMOVE_FILM,


    //Ticket
    BUY_TICKET
}
