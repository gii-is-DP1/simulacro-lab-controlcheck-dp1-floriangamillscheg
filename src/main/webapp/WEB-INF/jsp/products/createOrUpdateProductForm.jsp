<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="parchisoca" tagdir="/WEB-INF/tags" %>
<parchisoca:layout pageName="product">
    <div class="row">

    <!-- FORM for creating new game -->
    <div class="col-md-6 p-3 m-3 border border-secondary w-100 rounded">
    <h2 class="lead">New game</h2>
    <hr>
    <form:form method="POST" modelAttribute="product">
        <div class="section2">
            <div class="row">
                <div class="col-3 text-end">
                    <h3>Game name :</h3>
                </div>
                <div class="col">
                    <div class="form-group" ${status.error ? 'has-error' : '' }>
                        <form:input class="form-control" path="name" type="text" id="name"
                                    placeholder="name" />
                        <form:errors path="name" />
                    </div>
                </div>
                <div class="col">
                    <div class="form-group" ${status.error ? 'has-error' : '' }>
                        <form:input class="form-control" path="price" type="text" id="price"
                                    placeholder="price" />
                        <form:errors path="price" />
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-3 text-end">
                    <h3>Game type :</h3>
                </div>
                <div class="col">
                    <div class="form-group" ${status.error ? 'has-error' : '' }>
                        <form:select id="game_type" path="type">
                            <form:option value="Accessories" label="Accessories" />
                            <form:option value="Food" label="Food" />
                        </form:select>
                    </div>
                </div>
            </div>
            </div>
            <br>
            <div class="row form-group">
                <button type="submit" class="btn btn-md btn-primary"> New Game </button>
            </div>
        </div>
    </form:form>
</parchisoca:layout>
