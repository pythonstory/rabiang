<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../../common/inc.jspf" %>
<div class="row">
    <div class="col-md-6">
        <form action="{{ url_for('page.category_create') }}" method="post"
              class="form-horizontal">
            {{ form.csrf_token }}
            <div class="form-group">
                {{ form.name.label(class='col-sm-3 control-label') }}
                <div class="col-sm-9{% if form.name.errors %} has-error{% endif %}">
                    {{ form.name(class='form-control') }}
                    {% if form.name.errors %}
                        {% for error in form.name.errors %}
                            <span class="help-block">{{ error }}</span>
                        {% endfor %}
                    {% endif %}
                </div>
            </div>
            <div class="form-group">
                {{ form.order.label(class='col-sm-3 control-label') }}
                <div class="col-sm-9{% if form.order.errors %} has-error{% endif %}">
                    {{ form.order(class='form-control') }}
                    {% if form.order.errors %}
                        {% for error in form.order.errors %}
                            <span class="help-block">{{ error }}</span>
                        {% endfor %}
                    {% endif %}
                </div>
            </div>
            <div class="form-group">
                {{ form.parent.label(class='col-sm-3 control-label') }}
                <div class="col-sm-9{% if form.parent.errors %} has-error{% endif %}">
                    {{ form.parent(class='form-control') }}
                    {% if form.parent.errors %}
                        {% for error in form.parent.errors %}
                            <span class="help-block">{{ error }}</span>
                        {% endfor %}
                    {% endif %}
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-9">
                    <button type="submit"
                            class="btn btn-primary">{{ _('Save') }}</button>
                    <a href="{{ url_for('page.category_index') }}"
                       class="btn btn-default">{{ _('Cancel') }}</a>
                </div>
            </div>
        </form>
    </div>
    <div class="col-md-6">
        <table class="table table-striped">
            <tr>
                <th>{{ _('Category') }}</th>
                <th>{{ _('Actions') }}</th>
            </tr>
            {% for id, name, level in categories %}
                <tr>
                    <td>{{ ('&nbsp;&nbsp;&nbsp;&nbsp;' | safe) * level }}{{ name }}</td>
                    <td>
                        <a href="{{ url_for('page.category_edit', category_id=id) }}" class="btn btn-primary">Edit</a>
                        <a href="{{ url_for('page.category_delete', category_id=id) }}" class="btn btn-danger">Delete</a>
                    </td>
                </tr>
            {% endfor %}
        </table>
    </div>
</div>