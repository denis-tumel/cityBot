<#import "ui.ftl" as ui/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>City</title>
</head>
<body>

<div>
    <fieldset>
        <legend>Добавить город</legend>
        <form name="car" action="" method="post">
            Город : <label>
                <input type="text" name="city" />
            </label> <br/>
            Текст ответа: <label>
                <input type="text" name="description" />
            </label> <br/>
            <input type="submit" value="   Save   " />
        </form>
    </fieldset>
</div>


<#list cityGuides as city>
    <li>
        <tr>
            <td>${city.city}</td>
            <td>${city.description}</td>
        </tr>
    </li>
    <a>изменить</a>
</#list>
<p><#if lastSearch??>Поиск для: ${lastSearch}<#else></#if></p>

<@ui.table id="table1" rows=persons![]/>

</body>
</html>