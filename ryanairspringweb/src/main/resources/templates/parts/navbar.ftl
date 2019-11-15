<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Ticket App</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/main">Messages</a>
            </li>
            <li>
                <a class="nav-link" href="/directions">Direction list</a>
            </li>
            <li>
                <a class="nav-link" href="/schedules">Schedule list</a>
            </li>

            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/user">User list</a>
                </li>
                <li>
                    <a class="nav-link" href="/aircrafts">Aircraft list</a>
                </li>
                <li>
                    <a class="nav-link" href="/airports">Airport list</a>
                </li>
                <li>
                    <a class="nav-link" href="/bookings">Booking list</a>
                </li>
                <li>
                    <a class="nav-link" href="/clients">Client's list</a>
                </li>
                <li>
                    <a class="nav-link" href="/directions">Direction list</a>
                </li>
                <li>
                    <a class="nav-link" href="/flightSeatPrices">Flight Seat Price list</a>
                </li>
                <li>
                    <a class="nav-link" href="/flightStatuses">FlightStatus list</a>
                </li>
                <li>
                    <a class="nav-link" href="/schedules">Schedule list</a>
                </li>
            </#if>
        </ul>

        <div class="navbar-text mr-3">${name}</div>
        <@l.logout />
    </div>
</nav>