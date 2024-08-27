package com.example.projektv1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projektv1.databinding.FragmentManagerBinding

class ManagerContactFragment : Fragment() {

    lateinit var managerBinding: FragmentManagerBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        managerBinding = FragmentManagerBinding.inflate(inflater, container, false)
        //initializeUI()
        return managerBinding.root
    }

    companion object {
        fun newInstance(): ManagerContactFragment{
            return ManagerContactFragment()
        }

    }

}
