<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../../common/inc.jspf" %>
<form action="{{ url_for('page.category_delete', category_id=page_category.id) }}" method="post">
    {{ form.csrf_token }}
    <fieldset>
        <legend>{{ _('Delete this category?') }}</legend>
        {{ form.submit(class='btn btn-danger') }}
        <a class="btn btn-default" href="{{ url_for('page.category_edit', category_id=page_category.id) }}">{{ _('Cancel') }}</a>
    </fieldset>
</form>