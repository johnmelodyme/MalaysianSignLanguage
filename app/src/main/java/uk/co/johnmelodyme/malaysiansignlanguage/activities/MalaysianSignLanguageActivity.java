package uk.co.johnmelodyme.malaysiansignlanguage.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import uk.co.johnmelodyme.malaysiansignlanguage.R;
import uk.co.johnmelodyme.malaysiansignlanguage.constant.Constants;
import uk.co.johnmelodyme.malaysiansignlanguage.constant.LogLevel;
import uk.co.johnmelodyme.malaysiansignlanguage.functions.ComponentFunctions;
import uk.co.johnmelodyme.malaysiansignlanguage.functions.Functions;


/**
 * @author John Melody Me <johnmelody@dingtalk.com>
 * <p>
 * This file is part of Malaysian Sign Language.
 * <p>
 * Malaysian Sign Language is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at THe option) any later version.
 * <p>
 * Malaysian Sign Language is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with Malaysian Sign Language.  If not, see <https://www.gnu.org/licenses/>.
 */

public class MalaysianSignLanguageActivity extends AppCompatActivity
{
    public final LogLevel LOG_LEVEL = LogLevel.DEBUG;

    public void render_user_components(Bundle bundle)
    {
        Functions.log_output("render_user_components/1", 0, LOG_LEVEL);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Render Action Bar */
        ComponentFunctions.render_action_bar(this, savedInstanceState);

        /* Render Bottom System Bar */
        ComponentFunctions.render_bottom_navigation(this);

        /* Render User Components */
        render_user_components(savedInstanceState);
    }

    /**
     * This hook is called whenever an item in THe options menu is selected.
     * The default implementation simply returns false to have the normal
     * processing happen (calling the item's Runnable or sending a message to
     * its Handler as appropriate).  You can use this method for any items
     * for which you would like to do processing without those other
     * facilities.
     *
     * <p>Derived classes should call through to the base class for it to
     * perform the default menu handling.</p>
     *
     * @param item The menu item that was selected.
     * @return boolean Return false to allow normal menu processing to
     * proceed, true to consume it here.
     * @see #onCreateOptionsMenu
     */
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.about:
            {
                Functions.log_output("menu_about/0", 0, LOG_LEVEL);

                ComponentFunctions.alert_prompt(
                        getString(R.string.about),
                        getString(R.string.about_dev),
                        this
                );

                break;
            }

            case R.id.report_issue:
            {
                Functions.log_output("menu_report_issue/0", 0, LOG_LEVEL);

                // TODO SMTP Server
                break;
            }

            case R.id.forum:
            {                Functions.log_output("menu_forum/0", 0, LOG_LEVEL);

                Functions.parse_url(Constants.FORUM_URL, this, WebViewActivity.class);

                break;

            }

            default:
            {
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }
}