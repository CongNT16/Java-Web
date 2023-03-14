<%-- 
    Document   : book1
    Created on : Nov 4, 2022, 12:03:39 AM
    Author     : asus
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@page import ="java.util.ArrayList"%> 
<%@page import ="Model.movie"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Basic Page Needs -->
        <meta charset="utf-8">
        <title>CozzyCinema - Booking step 1</title>
        <meta name="description" content="A Template by Gozha.net">
        <meta name="keywords" content="HTML, CSS, JavaScript">
        <meta name="author" content="Gozha.net">

        <!-- Mobile Specific Metas-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta content="telephone=no" name="format-detection">

        <!-- Fonts -->
        <!-- Font awesome - icon font -->
        <link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
        <!-- Roboto -->
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,700' rel='stylesheet' type='text/css'>

        <!-- Stylesheets -->
        <!-- jQuery UI --> 
        <link href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css" rel="stylesheet">

        <!-- Mobile menu -->
        <link href="css/gozha-nav.css" rel="stylesheet" />
        <!-- Select -->
        <link href="css/external/jquery.selectbox.css" rel="stylesheet" />
        <!-- Swiper slider -->
        <link href="css/external/idangerous.swiper.css" rel="stylesheet" />

        <!-- Custom -->
        <link href="css/style.css?v=1" rel="stylesheet" />

        <!-- Modernizr --> 
        <script src="js/external/modernizr.custom.js"></script>

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries --> 
        <!--[if lt IE 9]> 
            <script src="http://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7/html5shiv.js"></script> 
                    <script src="http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.3.0/respond.js"></script>		
        <![endif]-->
    </head>

    <body>
        <%
       ArrayList<movie> list = new ArrayList<movie>();
       if(request.getAttribute("list")!=null){
       list = (ArrayList<movie>) request.getAttribute("list");
           }
        %>
        <div class="wrapper">


        </header>



        <!-- Main content -->

        <section class="container">
            <div class="order-container">
                <div class="order">
                    <img class="order__images" alt='' src="images/tickets.png">
                    <p class="order__title">Book a ticket <br><span class="order__descript">and have fun movie time</span></p>
                    <div class="order__control">
                        <a href="#" class="order__control-btn active">Purchase</a>

                    </div>
                </div>
            </div>
            <div class="order-step-area">
                <div class="order-step first--step">1. What &amp; Where &amp; When</div>
            </div>

            <h2 class="page-heading heading--outcontainer">Choose a movie</h2>
        </section>



        <section class="container">
            <form action="book1">
                <input type="text" hidden name='account' value="${sessionScope.account}">


                <div class="col-sm-12">
                    <div class="choose-indector choose-indector--film">
                        <strong>Choosen: </strong><span class="choosen-area"></span>
                    </div>
                    <h2 class="page-heading">Choose Movie</h2>
                    <select name="select-movie">
                        <option value="Black Adam">Black Adam</option>
                        <option value="Bullet Train">Bullet Train</option>
                        <option value="Prey for the devils">Prey for the devils</option>
                        <option value="6/45">6/45</option>
                        <option value="Smile">Smile</option>
                        <option value="Gonjo2">Gonjo2</option>
                        <option value="Dune">Dune</option>
                        <option value="No time to die">No time to die</option>
                        <option value="Prisoner of The Ghostland">Prisoner of The Ghostland</option>
                        <option value="The Suicide Squad">The Suicide Squad</option>
                        <option value="Black Panther 2">Black Panther 2</option>
                        <option value="Raya and the last dragon">Raya and the last dragon</option>
                        <option value="Venom2">Venom2</option>
                        <option value="Deapool2">Deapool2</option>
                        <option value="The tomorrow war">The tomorrow war</option>
                        <option value="Jungle Cruise">Jungle Cruise</option>
                    </select>

                    <h2 class="page-heading">Cinema; Date</h2>

                    <div class="choose-container choose-container--short">

                        <select name="select_item" id="select-sort" class="select__sort" tabindex="0">
                            <option value="Ha Noi Cinema" selected='selected'>Ha Noi Cinema</option>
                            <option value="Ha Tinh Cinema">Ha Tinh Cinema</option>
                            <option value="Da Nang Cinema">Da Nang Cinema</option>
                            <option value="Hue Cinema">Hue Cinema</option>
                            <option value="Ho Chi Minh Cinema">Ho Chi Minh Cinema</option>
                            <option value="Hai Phong Cinema">Hai Phong Cinema</option>

                        </select>


                        <div class="datepicker">
                            <span class="datepicker__marker"><i class="fa fa-calendar"></i>Date</span>
                            <input type="date" id="datepicker" name="date" class="datepicker__input">
                        </div>
                    </div>

                    <h2 class="page-heading">Pick time</h2>

                    <div class="time-select time-select--wide">
                        <div class="time-select__group group--first">


                            <div class="time-select__group">
                                <div class="col-sm-3">
                                    <p class="time-select__place">Please choose time</p>
                                </div>
                                <select name="time">
                                    <option value="07:30">07:30</option>
                                    <option value="10:00">10:00</option>
                                    <option value="13:00">13:00</option>
                                    <option value="15:00">15:00</option>
                                    <option value="17:00">17:30</option>
                                    <option value="20:00">20:00</option>
                                    <option value="21:00">21:00</option>
                                    <option value="23:00">23:00</option>

                                </select>

                            </div>

                            <div class="choose-sits">
                                <div class="choose-sits__info choose-sits__info--first">
                                    <ul>
                                        <li class="sits-price marker--none"><strong>Price</strong></li>
                                        <li class="sits-price sits-price--cheap">$10</li>
                                        <li class="sits-price sits-price--middle">$20</li>
                                        <li class="sits-price sits-price--expensive">$30</li>
                                    </ul>
                                </div>

                                <div class="choose-sits__info">
                                    <ul>
                                        <li class="sits-state sits-state--not">Your choice</li>
                                        
                                    </ul>

                                </div>
                                <div class="col-sm-12 col-lg-10 col-lg-offset-1">
                                    <div class="sits-area hidden-xs">
                                        <div class="sits-anchor">screen</div>

                                        <div class="sits">
                                            <aside class="sits__line">
                                                <span class="sits__indecator" >A</span>
                                                <span class="sits__indecator">B</span>
                                                <span class="sits__indecator">C</span>
                                                <span class="sits__indecator">D</span>
                                                <span class="sits__indecator">E</span>
                                                <span class="sits__indecator">F</span>
                                                <span class="sits__indecator">G</span>
                                                <span class="sits__indecator">I</span>
                                                <span class="sits__indecator additional-margin">J</span>
                                                <span class="sits__indecator">K</span>
                                                <span class="sits__indecator">L</span>
                                            </aside>
                                          


                                                <div class="sits__row">
                                                    <span class="sits__place sits-price--cheap" value="A1" name="seat" data-price='10'>A1</span>
                                                    <span class="sits__place sits-price--cheap" value="A2" name="seat" data-price='10'>A2</span>
                                                    <span class="sits__place sits-price--cheap" value="A3" name="seat" data-price='10'>A3</span>
                                                    <span class="sits__place sits-price--cheap" value="A4" name="seat" data-place='A4' data-price='10'>A4</span>
                                                    <span class="sits__place sits-price--cheap" data-place='A5'value="A5" name="seat" data-price='10'>A5</span>
                                                    <span class="sits__place sits-price--cheap" data-place='A6'value="A6" name="seat" data-price='10'>A6</span>
                                                    <span class="sits__place sits-price--cheap" data-place='A7'value="A7" name="seat" data-price='10'>A7</span>
                                                    <span class="sits__place sits-price--cheap" data-place='A8'value="A8" name="seat" data-price='10'>A8</span>
                                                    <span class="sits__place sits-price--cheap" data-place='A9'value="A9" name="seat" data-price='10'>A9</span>
                                                    <span class="sits__place sits-price--cheap" data-place='A10'value="A10" name="seat" data-price='10'>A10</span>
                                                    <span class="sits__place sits-price--cheap" data-place='A11' value="A11"name="seat" data-price='10'>A11</span>
                                                    <span class="sits__place sits-price--cheap" data-place='A12'value="A12" name="seat" data-price='10'>A12</span>
                                                    <span class="sits__place sits-price--cheap" data-place='A13'value="A13" name="seat" data-price='10'>A13</span>
                                                    <span class="sits__place sits-price--cheap" data-place='A14'value="A14" name="seat" data-price='10'>A14</span>
                                                    <span class="sits__place sits-price--cheap" data-place='A15'value="A15" name="seat" data-price='10'>A15</span>
                                                    <span class="sits__place sits-price--cheap" data-place='A16' value="A16"name="seat" data-price='10'>A16</span>
                                                    <span class="sits__place sits-price--cheap" data-place='A17'value="A17"name="seat" data-price='10'>A17</span>
                                                    <span class="sits__place sits-price--cheap" data-place='A18'value="A18"name="seat" data-price='10'>A18</span>
                                                </div>

                                                <div class="sits__row">
                                                    <span class="sits__place sits-price--cheap" value="B1" data-place='B1' name="seat" data-price='10'>B1</span>
                                                    <span class="sits__place sits-price--cheap" value="B2" data-place='B2'name="seat"  data-price='10'>B2</span>
                                                    <span class="sits__place sits-price--cheap" value="B3" data-place='B3' name="seat" data-price='10'>B3</span>
                                                    <span class="sits__place sits-price--cheap" value="B4" data-place='B4' name="seat" data-price='10'>B4</span>
                                                    <span class="sits__place sits-price--cheap" value="B5" data-place='B5' name="seat" data-price='10'>B5</span>
                                                    <span class="sits__place sits-price--cheap" value="B6" data-place='B6' name="seat" data-price='10'>B6</span>
                                                    <span class="sits__place sits-price--cheap" value="B7" data-place='B7' name="seat" data-price='10'>B7</span>
                                                    <span class="sits__place sits-price--cheap" value="B8" data-place='B8' name="seat" data-price='10'>B8</span>
                                                    <span class="sits__place sits-price--cheap" value="B9" data-place='B9' name="seat" data-price='10'>B9</span>
                                                    <span class="sits__place sits-price--cheap" sits-state--not value="B10" data-place='B10'name="seat"  data-price='10'>B10</span>
                                                    <span class="sits__place sits-price--cheap" sits-state--not value="B11" data-place='B11' name="seat" data-price='10'>B11</span>
                                                    <span class="sits__place sits-price--cheap" sits-state--not value="B12" data-place='B12' name="seat" data-price='10'>B12</span>
                                                    <span class="sits__place sits-price--cheap" value="B13" data-place='B13' name="seat" data-price='10'>B13</span>
                                                    <span class="sits__place sits-price--cheap" value="B14" data-place='B14' name="seat" data-price='10'>B14</span>
                                                    <span class="sits__place sits-price--cheap" value="B15" data-place='B15' name="seat" data-price='10'>B15</span>
                                                    <span class="sits__place sits-price--cheap" value="B16" data-place='B16' name="seat" data-price='10'>B16</span>
                                                    <span class="sits__place sits-price--cheap" value="B17" data-place='B17' name="seat" data-price='10'>B17</span>
                                                    <span class="sits__place sits-price--cheap" value="B18" data-place='B18' name="seat" data-price='10'>B18</span>
                                                </div>

                                                <div class="sits__row">
                                                    <span class="sits__place sits-price--cheap" value="C1" data-place='C1' name="seat" data-price='10'>C1</span>
                                                    <span class="sits__place sits-price--cheap" value="C2" data-place='C2' name="seat" data-price='10'>C2</span>
                                                    <span class="sits__place sits-price--cheap" value="C3" data-place='C3' name="seat" data-price='10'>C3</span>
                                                    <span class="sits__place sits-price--cheap" sits-state--not value="C4" data-place='C4'name="seat"  data-price='10'>C4</span>
                                                    <span class="sits__place sits-price--cheap" sits-state--not value="C5" data-place='C5'name="seat"  data-price='10'>C5</span>
                                                    <span class="sits__place sits-price--cheap" value="C6" data-place='C6'name="seat"  data-price='10'>C6</span>
                                                    <span class="sits__place sits-price--cheap" value="C7" data-place='C7'name="seat"  data-price='10'>C7</span>
                                                    <span class="sits__place sits-price--cheap" value="C8" data-place='C8' name="seat" data-price='10'>C8</span>
                                                    <span class="sits__place sits-price--cheap" value="C9" data-place='C9' name="seat" data-price='10'>C9</span>
                                                    <span class="sits__place sits-price--cheap" value="C10" data-place='C10'name="seat"  data-price='10'>C10</span>
                                                    <span class="sits__place sits-price--cheap" value="C11" data-place='C11' name="seat" data-price='10'>C11</span>
                                                    <span class="sits__place sits-price--cheap" sits-state--notvalue="C12" data-place='C12' name="seat" data-price='10'>C12</span>
                                                    <span class="sits__place sits-price--cheap" value="C13" data-place='C13' name="seat" data-price='10'>C13</span>
                                                    <span class="sits__place sits-price--cheap" value="C14" data-place='C14' name="seat" data-price='10'>C14</span>
                                                    <span class="sits__place sits-price--cheap" value="C15" data-place='C15' name="seat" data-price='10'>C15</span>
                                                    <span class="sits__place sits-price--cheap" value="C16" data-place='C16' name="seat" data-price='10'>C16</span>
                                                    <span class="sits__place sits-price--cheap" value="C17" data-place='C17'name="seat"  data-price='10'>C17</span>
                                                    <span class="sits__place sits-price--cheap" value="C18" data-place='C18' name="seat" data-price='10'>C18</span>
                                                </div>

                                                <div class="sits__row">
                                                    <span class="sits__place sits-price--cheap" value="D1" data-place='D1' name="seat" data-price='10'>D1</span>
                                                    <span class="sits__place sits-price--cheap" value="D2" data-place='D2'name="seat"  data-price='10'>D2</span>
                                                    <span class="sits__place sits-price--cheap" value="D3" data-place='D3' name="seat" data-price='10'>D3</span>
                                                    <span class="sits__place sits-price--cheap" value="D4" data-place='D4'name="seat"  data-price='10'>D4</span>
                                                    <span class="sits__place sits-price--cheap" value="D5" data-place='D5' name="seat" data-price='10'>D5</span>
                                                    <span class="sits__place sits-price--cheap" value="D6" data-place='D6' name="seat" data-price='10'>D6</span>
                                                    <span class="sits__place sits-price--cheap sits-state--not" value="D7" name="seat" data-place='D7' data-price='10'>D7</span>
                                                    <span class="sits__place sits-price--cheap sits-state--not" value="D8" name="seat" data-place='D8' data-price='10'>D8</span>
                                                    <span class="sits__place sits-price--cheap" value="D9" data-place='D9' name="seat" data-price='10'>D9</span>
                                                    <span class="sits__place sits-price--cheap" value="D10" data-place='D10' name="seat" data-price='10'>D10</span>
                                                    <span class="sits__place sits-price--cheap" value="D11" data-place='D11' name="seat" data-price='10'>D11</span>
                                                    <span class="sits__place sits-price--cheap" value="D12" data-place='D12' name="seat" data-price='10'>D12</span>
                                                    <span class="sits__place sits-price--cheap" value="D13" data-place='D13' name="seat" data-price='10'>D13</span>
                                                    <span class="sits__place sits-price--cheap" value="D14" data-place='D14' name="seat" data-price='10'>D14</span>
                                                    <span class="sits__place sits-price--cheap" value="D15" data-place='D15' name="seat" data-price='10'>D15</span>
                                                    <span class="sits__place sits-price--cheap" value="D16" data-place='D16' name="seat" data-price='10'>D16</span>
                                                    <span class="sits__place sits-price--cheap" value="D17" data-place='D17'name="seat"  data-price='10'>D17</span>
                                                    <span class="sits__place sits-price--cheap" value="D18" data-place='D18'name="seat"  data-price='10'>D18</span>
                                                </div>

                                                <div class="sits__row">
                                                    <span class="sits__place sits-price--middle" value="E1" data-place='E1'name="seat"  data-price='20'>E1</span>
                                                    <span class="sits__place sits-price--middle" value="E2" data-place='E2'name="seat"  data-price='20'>E2</span>
                                                    <span class="sits__place sits-price--middle" value="E3" data-place='E3'name="seat"  data-price='20'>E3</span>
                                                    <span class="sits__place sits-price--middle" value="E4" data-place='E4'name="seat"  data-price='20'>E4</span>
                                                    <span class="sits__place sits-price--middle" value="E5" data-place='E5' name="seat" data-price='20'>E5</span>
                                                    <span class="sits__place sits-price--middle" value="E6" data-place='E6' name="seat" data-price='20'>E6</span>
                                                    <span class="sits__place sits-price--middle" value="E7" data-place='E7' name="seat" data-price='20'>E7</span>
                                                    <span class="sits__place sits-price--middle" value="E8" data-place='E8' name="seat" data-price='20'>E8</span>
                                                    <span class="sits__place sits-price--middle" sits-state--not value="E9" data-place='E9' name="seat" data-price='20'>E9</span>
                                                    <span class="sits__place sits-price--middle" sits-state--not value="E10" data-place='E10' name="seat" data-price='20'>E10</span>
                                                    <span class="sits__place sits-price--middle" sits-state--not value="E11" data-place='E11' name="seat" data-price='20'>E11</span>
                                                    <span class="sits__place sits-price--middle" value="E12" data-place='E12' name="seat" data-price='20'>E12</span>
                                                    <span class="sits__place sits-price--middle" value="E13" data-place='E13' name="seat" data-price='20'>E13</span>
                                                    <span class="sits__place sits-price--middle" value="E14" data-place='E14'name="seat"  data-price='20'>E14</span>
                                                    <span class="sits__place sits-price--middle" value="E15" data-place='E15'name="seat"  data-price='20'>E15</span>
                                                    <span class="sits__place sits-price--middle" value="E16" data-place='E16'name="seat"  data-price='20'>E16</span>
                                                    <span class="sits__place sits-price--middle" value="E17" data-place='E17'name="seat"  data-price='20'>E17</span>
                                                    <span class="sits__place sits-price--middle" value="E18" data-place='E18'name="seat"  data-price='20'>E18</span>
                                                </div>

                                                <div class="sits__row">
                                                    <span class="sits__place sits-price--middle" value="F1" data-place='F1' name="seat" data-price='20'>F1</span>
                                                    <span class="sits__place sits-price--middle" value="F2" data-place='F2'name="seat"  data-price='20'>F2</span>
                                                    <span class="sits__place sits-price--middle" sits-state--not value="F3" data-place='F3'name="seat"  data-price='20'>F3</span>
                                                    <span class="sits__place sits-price--middle" value="F4" data-place='F4'name="seat"  data-price='20'>F4</span>
                                                    <span class="sits__place sits-price--middle" sits-state--not value="F5" data-place='F5'name="seat"  data-price='20'>F5</span>
                                                    <span class="sits__place sits-price--middle" value="F6" data-place='F6'name="seat"  data-price='20'>F6</span>
                                                    <span class="sits__place sits-price--middle" value="F7" data-place='F7' name="seat" data-price='20'>F7</span>
                                                    <span class="sits__place sits-price--middle" value="F8" data-place='F8'name="seat"  data-price='20'>F8</span>
                                                    <span class="sits__place sits-price--middle" value="F9" data-place='F9' name="seat" data-price='20'>F9</span>
                                                    <span class="sits__place sits-price--middle" value="F10" data-place='F10' name="seat" data-price='20'>F10</span>
                                                    <span class="sits__place sits-price--middle" value="F11" data-place='F11' name="seat" data-price='20'>F11</span>
                                                    <span class="sits__place sits-price--middle" sits-state--not value="F12" data-place='F12' name="seat" data-price='20'>F12</span>
                                                    <span class="sits__place sits-price--middle" sits-state--not value="F13" data-place='F13'name="seat"  data-price='20'>F13</span>
                                                    <span class="sits__place sits-price--middle" value="F14" data-place='F14' name="seat" data-price='20'>F14</span>
                                                    <span class="sits__place sits-price--middle" value="F15" data-place='F15'name="seat"  data-price='20'>F15</span>
                                                    <span class="sits__place sits-price--middle" value="F16" data-place='F16' name="seat" data-price='20'>F16</span>
                                                    <span class="sits__place sits-price--middle" sits-state--not value="F17" data-place='F17' name="seat" data-price='20'>F17</span>
                                                    <span class="sits__place sits-price--middle" value="F18" data-place='F18' name="seat" data-price='20'>F18</span>
                                                </div>

                                                <div class="sits__row">
                                                    <span class="sits__place sits-price--middle" value="G1" data-place='G1'name="seat"  data-price='20'>G1</span>
                                                    <span class="sits__place sits-price--middle" value="G2" data-place='G2'name="seat"  data-price='20'>G2</span>
                                                    <span class="sits__place sits-price--middle" value="G3" data-place='G3'name="seat"  data-price='20'>G3</span>
                                                    <span class="sits__place sits-price--middle" value="G4" data-place='G4'name="seat"  data-price='20'>G4</span>
                                                    <span class="sits__place sits-price--middle" value="G5" data-place='G5'name="seat"  data-price='20'>G5</span>
                                                    <span class="sits__place sits-price--middle" value="G6" data-place='G6' name="seat" data-price='20'>G6</span>
                                                    <span class="sits__place sits-price--middle" value="G7" data-place='G7'name="seat"  data-price='20'>G7</span>
                                                    <span class="sits__place sits-price--middle" value="G8" data-place='G8'name="seat"  data-price='20'>G8</span>
                                                    <span class="sits__place sits-price--middle" value="G9" data-place='G9'name="seat"  data-price='20'>G9</span>
                                                    <span class="sits__place sits-price--middle" value="G10" data-place='G10' name="seat" data-price='20'>G10</span>
                                                    <span class="sits__place sits-price--middle" value="G11" data-place='G11'name="seat"  data-price='20'>G11</span>
                                                    <span class="sits__place sits-price--middle" sits-state--not value="G12" data-place='G12'name="seat"  data-price='20'>G12</span>
                                                    <span class="sits__place sits-price--middle" value="G13" data-place='G13'name="seat"  data-price='20'>G13</span>
                                                    <span class="sits__place sits-price--middle" value="G14" data-place='G14'name="seat"  data-price='20'>G14</span>
                                                    <span class="sits__place sits-price--middle" value="G15" data-place='G15'name="seat"  data-price='20'>G15</span>
                                                    <span class="sits__place sits-price--middle" value="G16" data-place='G16' name="seat" data-price='20'>G16</span>
                                                    <span class="sits__place sits-price--middle" value="G17" data-place='G17' name="seat" data-price='20'>G17</span>
                                                    <span class="sits__place sits-price--middle" value="G18" data-place='G18' name="seat" data-price='20'>G18</span>
                                                </div>

                                                <div class="sits__row">
                                                    <span class="sits__place sits-price--middle" value="I1" data-place='I1'name="seat"  data-price='20'>I1</span>
                                                    <span class="sits__place sits-price--middle" value="I2" data-place='I2'name="seat"  data-price='20'>I2</span>
                                                    <span class="sits__place sits-price--middle" value="I3" data-place='I3'name="seat"  data-price='20'>I3</span>
                                                    <span class="sits__place sits-price--middle" value="I4" data-place='I4'name="seat"  data-price='20'>I4</span>
                                                    <span class="sits__place sits-price--middle" value="I5" data-place='I5'name="seat"  data-price='20'>I5</span>
                                                    <span class="sits__place sits-price--middle" value="I6" data-place='I6'name="seat"  data-price='20'>I6</span>
                                                    <span class="sits__place sits-price--middle" sits-state--not value="I7" data-place='I7'name="seat"  data-price='20'>I7</span>
                                                    <span class="sits__place sits-price--middle" value="I8" data-place='I8'name="seat"  data-price='20'>I8</span>
                                                    <span class="sits__place sits-price--middle" value="I9" data-place='I9' name="seat" data-price='20'>I9</span>
                                                    <span class="sits__place sits-price--middle" value="I10" data-place='I10'name="seat"  data-price='20'>I10</span>
                                                    <span class="sits__place sits-price--middle" sits-state--not value="I11" data-place='I11'name="seat"  data-price='20'>I11</span>
                                                    <span class="sits__place sits-price--middle" value="I12" data-place='I12' name="seat" data-price='20'>I12</span>
                                                    <span class="sits__place sits-price--middle" value="I13" data-place='I13'name="seat"  data-price='20'>I13</span>
                                                    <span class="sits__place sits-price--middle" value="I14" data-place='I14'name="seat"  data-price='20'>I14</span>
                                                    <span class="sits__place sits-price--middle" value="I15" data-place='I15'name="seat"  data-price='20'>I15</span>
                                                    <span class="sits__place sits-price--middle" value="I16" data-place='I16'name="seat"  data-price='20'>I16</span>
                                                    <span class="sits__place sits-price--middle" value="I17" data-place='I17'name="seat"  data-price='20'>I17</span>
                                                    <span class="sits__place sits-price--middle" value="I18" data-place='I18'name="seat"  data-price='20'>I18</span>
                                                </div>


                                                <aside class="sits__checked">
                                                    <div class="checked-place">

                                                    </div>
                                                </aside>
                                                <footer class="sits__number">
                                                    <span class="sits__indecator">1</span>
                                                    <span class="sits__indecator">2</span>
                                                    <span class="sits__indecator">3</span>
                                                    <span class="sits__indecator">4</span>
                                                    <span class="sits__indecator">5</span>
                                                    <span class="sits__indecator">6</span>
                                                    <span class="sits__indecator">7</span>
                                                    <span class="sits__indecator">8</span>
                                                    <span class="sits__indecator">9</span>
                                                    <span class="sits__indecator">10</span>
                                                    <span class="sits__indecator">11</span>
                                                    <span class="sits__indecator">12</span>
                                                    <span class="sits__indecator">13</span>
                                                    <span class="sits__indecator">14</span>
                                                    <span class="sits__indecator">15</span>
                                                    <span class="sits__indecator">16</span>
                                                    <span class="sits__indecator">17</span>
                                                    <span class="sits__indecator">18</span>
                                                </footer>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="col-sm-12 visible-xs"> 
                                    <div class="sits-area--mobile">
                                        <div class="sits-area--mobile-wrap">
                                            <div class="sits-select">
                                                <select name="sorting_item" class="sits__sort sit-row" tabindex="0">
                                                    <option value="1" selected='selected'>A</option>
                                                    <option value="2">B</option>
                                                    <option value="3">C</option>
                                                    <option value="4">D</option>
                                                    <option value="5">E</option>
                                                    <option value="6">F</option>
                                                    <option value="7">G</option>
                                                    <option value="8">I</option>

                                                </select>


                                                <select name="sorting_item" class="sits__sort sit-number" tabindex="1">
                                                    <option value="1" selected='selected'>1</option>
                                                    <option value="2">2</option>
                                                    <option value="3">3</option>
                                                    <option value="4">4</option>
                                                    <option value="5">5</option>
                                                    <option value="6">6</option>
                                                    <option value="7">7</option>
                                                    <option value="8">8</option>
                                                    <option value="9">9</option>
                                                    <option value="10">10</option>
                                                    <option value="11">11</option>
                                                    <option value="12">12</option>
                                                    <option value="13">13</option>
                                                    <option value="14">14</option>
                                                    <option value="15">15</option>
                                                    <option value="16">16</option>
                                                    <option value="17">17</option>
                                                    <option value="18">18</option>
                                                </select>

                                                <a href="#" class="btn btn-md btn--warning toogle-sits">Choose sit</a>
                                            </div>
                                        </div>



                                        <aside class="sits__checked">
                                            <div class="checked-place">
                                                <span class="choosen-place"></span>
                                            </div>

                                        </aside>

                                        <img alt="" src="images/components/sits_mobile.png">
                                    </div>
                                </div>   

                            </div>

                        </div>
                        </section>
                    </div>
                    <div style="background-color: #7de5f9" class="booking-pagination booking-pagination--margin">
                        <h1>ENTER SEAT YOU WANT TO BOOK HERE</h1>
                            <b>Please enter column of seat here:</b>
                            <select name="seat-1">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                                <option value="13">13</option>
                                <option value="14">14</option>
                                <option value="15">15</option>
                                <option value="16">16</option>
                                <option value="17">17</option>
                                <option value="">18</option>

                            </select>

                            <div>
                                <b>Please enter row of seat here:</b>
                                <select name="seat-a">
                                    <option value="A">A</option>
                                    <option value="B">B</option>
                                    <option value="C">C</option>
                                    <option value="D">D</option>
                                    <option value="E">E</option>
                                    <option value="F">F</option>
                                    <option value="G">G</option>
                                    <option value="I">I</option>

                                </select>


                            </div>
 <input type="submit" value="next-step" style="margin-top: 30px; font-size: 20px; background-color: #00b3ee;border-radius: 15px; border: 2px solid black">

                    </div>

                   
                    </form>

                    <div class="clearfix"></div>
                    <div class="clearfix"></div>




                    <div class="clearfix"></div>

                    <footer class="footer-wrapper">
                        <section class="container">
                            <div class="col-xs-4 col-md-2 footer-nav">
                                <ul class="nav-link">
                                    <li><a href="#" class="nav-link__item">Cities</a></li>
                                    <li><a href="movie-list-left.html" class="nav-link__item">Movies</a></li>
                                    <li><a href="trailer.html" class="nav-link__item">Trailers</a></li>
                                    <li><a href="rates-left.html" class="nav-link__item">Rates</a></li>
                                </ul>
                            </div>
                            <div class="col-xs-4 col-md-2 footer-nav">
                                <ul class="nav-link">
                                    <li><a href="coming-soon.html" class="nav-link__item">Coming soon</a></li>
                                    <li><a href="cinema-list.html" class="nav-link__item">Cinemas</a></li>
                                    <li><a href="offers.html" class="nav-link__item">Best offers</a></li>
                                    <li><a href="news-left.html" class="nav-link__item">News</a></li>
                                </ul>
                            </div>
                            <div class="col-xs-4 col-md-2 footer-nav">
                                <ul class="nav-link">
                                    <li><a href="#" class="nav-link__item">Terms of use</a></li>
                                    <li><a href="gallery-four.html" class="nav-link__item">Gallery</a></li>
                                    <li><a href="contact.html" class="nav-link__item">Contacts</a></li>
                                    <li><a href="page-elements.html" class="nav-link__item">Shortcodes</a></li>
                                </ul>
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <div class="footer-info">
                                    <p class="heading-special--small">A.Movie<br><span class="title-edition">in the social media</span></p>

                                    <div class="social">
                                        <a href='#' class="social__variant fa fa-facebook"></a>
                                        <a href='#' class="social__variant fa fa-twitter"></a>
                                        <a href='#' class="social__variant fa fa-vk"></a>
                                        <a href='#' class="social__variant fa fa-instagram"></a>
                                        <a href='#' class="social__variant fa fa-tumblr"></a>
                                        <a href='#' class="social__variant fa fa-pinterest"></a>
                                    </div>

                                    <div class="clearfix"></div>
                                    <p class="copy">&copy; A.Movie, 2013. All rights reserved. Done by Olia Gozha</p>
                                </div>
                            </div>
                        </section>
                    </footer>
                </div>

                <!-- open/close -->
                <div class="overlay overlay-hugeinc">

                    <section class="container">

                        <div class="col-sm-4 col-sm-offset-4">
                            <button type="button" class="overlay-close">Close</button>
                            <form id="login-form" class="login" method='get' novalidate=''>
                                <p class="login__title">sign in <br><span class="login-edition">welcome to A.Movie</span></p>

                                <div class="social social--colored">
                                    <a href='#' class="social__variant fa fa-facebook"></a>
                                    <a href='#' class="social__variant fa fa-twitter"></a>
                                    <a href='#' class="social__variant fa fa-tumblr"></a>
                                </div>

                                <p class="login__tracker">or</p>

                                <div class="field-wrap">
                                    <input type='email' placeholder='Email' name='user-email' class="login__input">
                                    <input type='password' placeholder='Password' name='user-password' class="login__input">

                                    <input type='checkbox' id='#informed' class='login__check styled'>
                                    <label for='#informed' class='login__check-info'>remember me</label>
                                </div>

                                <div class="login__control">
                                    <button type='submit' class="btn btn-md btn--warning btn--wider">sign in</button>
                                    <a href="#" class="login__tracker form__tracker">Forgot password?</a>
                                </div>
                            </form>
                        </div>

                    </section>
                </div>


                <!-- JavaScript-->
                <!-- jQuery 1.9.1--> 
                <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
                <script>window.jQuery || document.write('<script src="js/external/jquery-1.10.1.min.js"><\/script>')</script>
                <!-- Migrate --> 
                <script src="js/external/jquery-migrate-1.2.1.min.js"></script>
                <!-- jQuery UI -->
                <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
                <!-- Bootstrap 3--> 
                <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>

                <!-- Mobile menu -->
                <script src="js/jquery.mobile.menu.js"></script>
                <!-- Select -->
                <script src="js/external/jquery.selectbox-0.2.min.js"></script>
                <!-- Swiper slider -->
                <script src="js/external/idangerous.swiper.min.js"></script>

                <!-- Form element -->
                <script src="js/external/form-element.js"></script>
                <!-- Form validation -->
                <script src="js/form.js"></script>

                <!-- Custom -->
                <script src="js/custom.js"></script>

                <script type="text/javascript">
                    $(document).ready(function () {
                        init_BookingOne();
                    });
                </script>

                </body>
                </html>
